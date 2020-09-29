package com.chibatching.certerror

import android.util.Base64
import java.io.ByteArrayInputStream
import java.io.File
import java.io.InputStream
import java.security.KeyFactory
import java.security.KeyStore
import java.security.PrivateKey
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate
import java.security.interfaces.RSAPrivateKey
import java.security.spec.PKCS8EncodedKeySpec

/**
 * Utility for Java KeyStore
 */
internal object KeyStoreUtil {

    /**
     * Create a KeyStore from standard PEM file
     * refer: https://github.com/eclipse/jetty.project/issues/1826
     *
     * @param privateKeyPem the private key PEM input stream
     * @param certificatePem the certificate(s) PEM input stream
     * @param password to set to protect the private key
     */
    fun createKeyStore(
        privateKeyPem: InputStream,
        certificatePem: InputStream,
        password: String = ""
    ): KeyStore {
        val keystore = KeyStore.getInstance(KeyStore.getDefaultType())
        keystore.load(null)

        val cert = createCertificates(certificatePem)
        val key = createPrivateKey(privateKeyPem)
        keystore.setKeyEntry("test", key, password.toCharArray(), cert)

        return keystore
    }

    /**
     * Save KeyStore to file
     * @param keyStore the key store to save
     * @param file target file
     * @param password key store password if needed
     */
    fun saveKeyStoreFile(keyStore: KeyStore, file: File, password: String = "") {
        keyStore.store(file.outputStream(), password.toCharArray())
    }

    /**
     * Load KeyStore from file
     * @param file the file of key store. If file doesn't exist, return null
     * @param password key store password if needed
     */
    fun loadKeyStoreFile(file: File, password: String = ""): KeyStore? {
        if (!file.exists()) {
            return null
        }
        val keystore = KeyStore.getInstance(KeyStore.getDefaultType())
        keystore.load(file.inputStream(), password.toCharArray())

        return keystore
    }

    private fun createPrivateKey(privateKeyPem: InputStream): PrivateKey {
        privateKeyPem.bufferedReader().use { br ->
            br.readLine().let {
                if (it == null || !it.contains("BEGIN RSA PRIVATE KEY")) {
                    br.close()
                    throw IllegalArgumentException("No PRIVATE KEY found")
                }
            }
            val sb = StringBuilder()
            br.forEachLine {
                if (it.contains("END RSA PRIVATE KEY")) {
                    return@forEachLine
                }
                sb.append(it)
            }
            return generatePrivateKeyFromDER(Base64.decode(sb.toString(), Base64.DEFAULT))
        }
    }

    private fun createCertificates(certificatePem: InputStream): Array<X509Certificate> {
        certificatePem.bufferedReader().use { br ->
            br.readLine().let {
                if (it == null || !it.contains("BEGIN CERTIFICATE")) {
                    br.close()
                    throw IllegalArgumentException("No CERTIFICATE found")
                }
            }
            val result = mutableListOf<X509Certificate>()
            var sb = StringBuilder()
            br.forEachLine {
                if (it.contains("END CERTIFICATE")) {
                    val cert =
                        generateCertificateFromDER(Base64.decode(sb.toString(), Base64.DEFAULT))
                    result.add(cert)
                    sb = StringBuilder()
                } else if (!it.startsWith("-----")) {
                    sb.append(it)
                }
            }
            return result.toTypedArray()
        }
    }

    private fun generatePrivateKeyFromDER(keyBytes: ByteArray): RSAPrivateKey {
        val spec = PKCS8EncodedKeySpec(keyBytes)
        val factory = KeyFactory.getInstance("RSA")
        return factory.generatePrivate(spec) as RSAPrivateKey
    }

    private fun generateCertificateFromDER(certBytes: ByteArray): X509Certificate {
        val factory = CertificateFactory.getInstance("X.509")
        return factory.generateCertificate(ByteArrayInputStream(certBytes)) as X509Certificate
    }
}
