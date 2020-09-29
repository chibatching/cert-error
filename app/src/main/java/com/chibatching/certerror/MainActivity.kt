package com.chibatching.certerror

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.security.ProviderInstaller
import java.io.ByteArrayInputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ProviderInstaller.installIfNeeded(this)

        val keyStore = KeyStoreUtil.createKeyStore(
            ByteArrayInputStream(
                "-----BEGIN RSA PRIVATE KEY-----\nMIIEowIBAAKCAQEAqqZqkMORcBOIUBqaeteWts3XwGqW5nlrnrIMKehatpFouuHc\nLQ1tYoD3aSkS2zNopWNnKMtKBbMBAYsI5kLH67H1hT0yvxoO1yWwGBA9zjJVUP/1\nbuHLcv3DYmTbSgQFtg94MlR63i+3/1PpZ4yEJxtOWYfdJJ/W5ipU+XdfsZFPgC7C\nbbiq0zHOI6vCjEug7z6ysqhE2i6S/X7Ty0S5Gt6U0bM6VQ4H6XBi96eZ/PDCjl2U\nhd8MOFLgtXgvXwJgaUCTuIBUT8qRwd87zlGOt6mvOySTHDs93N1cc6UYTluJRe6y\nz+447zM4cn30uulaaF5GEQh5BSzejD82/FYtnwIBAwKCAQBxxEcLLQugDQWKvGb8\nj7nPM+Uq8bnu+50UdrLGmuckYPB8lpLIs55Bq0+bcLc8zPBuQkTF3NwDzKtWXLCZ\ngdqdIU5Y03cqEV86GSAQCtPezDjgqqOfQTJMqSzsQzzcAq55X6V24vyUH8//jUZF\nCFgaEjQ7r+jDFTnuxuNQ+j/LtR461HD8ADHobsfoMLoO3uYUXLrf9GfuCf3peaCe\nIyrVphAGBbjnJxeOjsBvCa2rPeZwQNtHWT2URYU9sdhdYnQK7K9+gTJ8KEUK5blx\nq3I0yi+ciZNdir25n9aAW1vssrsfin2qwNmRyIAK6YrvQSeyL7bUtt5zfpt3jaom\nY5W7AoGBANZK/MgpswNnLD840zwXbREQrxGPf+oo3vAm0AC3j/orizLIVNNz4et6\nbesZ6kqqeYfGkCYlv5tl/vfVj0Qb/v0kKFj/RYKH/hyRves4RawE+v+sBLS3VnRU\nw5UXRXHD70o5dRmi/8cm/x38SU5W88yTN8IW8ulgtqQdCbL8rXRrAoGBAMvc81DK\nBVyPX2MOj29ekDbABIjTOb7MQKX4eGImf/6u2koAVdGGcXkZLFc3LsrRmmEfbCV1\nGZRz66EDXia277U0tTN7eQYNkA2fyLprirdjf2gkUYFYlKzxqgWb1pynYCZdKdys\nzStth1pl1lX9E9JJ3vG7A0H3OFE74QTGE1idAoGBAI7cqIVxIgJEyCol4igPngtg\ndLZfqpwbP0rEiqslCqbHsiHa4zeilpz8SUdmnDHG+6/ZtW7D1RJD/0/jtNgSqf4Y\nGuX/g6xaqWhhKUd62R1Yp1UdWHh6OaLjLQ4Pg6EtSjF7o2ZsqoTEqhP9hjQ59923\neoFkofDrJG1osSH9yPhHAoGBAIfoojXcA5MKP5dfCko/Cs8qrbCM0SndgG6lpZbE\nVVR0kYaq4+EES6YQyDokydyLvEC/nW5OEQ2inRYCPsR59SN4eMz8+1leYAkVMHxH\nsc+XqkVti6uQYx32cVkSjxMaQBmTcT3IiMeeWjxD5DlTYowxP0vSAiv6JYt9QK3Z\nYjsTAoGBAJIXLIVXvma8/4kzTIpN5DTRQ18Reed+WlWNI7Af6Zb0jwmvrqukpQ88\nQ9+EEAypaeA/mtouqD86NiTWjCXLeu6JuAX+D3CeR0BqotHcmvDOorc97kLivDka\nIKUSSbup0HQv4wBP40ckIOWDoh1qlw2N/GVNeFVab4zC0GltFqUf\n-----END RSA PRIVATE KEY-----\n".toByteArray(),
            ),
            ByteArrayInputStream(
                "-----BEGIN CERTIFICATE-----\nMIIDTjCCAjYCAQEwDQYJKoZIhvcNAQELBQAwUjELMAkGA1UEBhMCSlAxDjAMBgNV\nBAgTBVRva3lvMRcwFQYDVQQKEw5EZU5BIENvLiwgTHRkLjEaMBgGA1UEAxMRbWlh\ncy5kZXYubS1vLXYuanAwHhcNMjAwOTI5MDAwNzQ4WhcNNDAwOTI0MDAwNzQ4WjBM\nMQswCQYDVQQGEwJKUDEXMBUGA1UECgwORGVOQSBDby4sIEx0ZC4xJDAiBgNVBAMM\nG0NyZXdBcHAtMTAwMDAwMDc4NC5tLW8tdi5qcDCCASAwDQYJKoZIhvcNAQEBBQAD\nggENADCCAQgCggEBAKqmapDDkXATiFAamnrXlrbN18BqluZ5a56yDCnoWraRaLrh\n3C0NbWKA92kpEtszaKVjZyjLSgWzAQGLCOZCx+ux9YU9Mr8aDtclsBgQPc4yVVD/\n9W7hy3L9w2Jk20oEBbYPeDJUet4vt/9T6WeMhCcbTlmH3SSf1uYqVPl3X7GRT4Au\nwm24qtMxziOrwoxLoO8+srKoRNoukv1+08tEuRrelNGzOlUOB+lwYvenmfzwwo5d\nlIXfDDhS4LV4L18CYGlAk7iAVE/KkcHfO85Rjreprzskkxw7PdzdXHOlGE5biUXu\nss/uOO8zOHJ99LrpWmheRhEIeQUs3ow/NvxWLZ8CAQOjPDA6MAwGA1UdEwEB/wQC\nMAAwCwYDVR0PBAQDAgSQMB0GA1UdJQQWMBQGCCsGAQUFBwMCBggrBgEFBQcDCDAN\nBgkqhkiG9w0BAQsFAAOCAQEAuu4wDFbcpgEs3C37PBp5Qsc9R6RriBOWv41hN5fG\nIDSwQzpQ8zOTlHZZ+HHPpAIVB2JdVkyAS2p3m110rWDZMI/DEGwldpjQPBgNH19y\nXo+jz9dFIqobPvKSYGBPBxnJ4+vk7A95qPPLLwpofbFdFe2aiD4myuR+kL/DlIyZ\ne1QQfz8R2n4T67gSQRNL1mGgrPo5n/d08cekyD4LwCiVsC34oPQEhMlyrOXH9D38\niXELq6arcePFMyLXZcp6YaQJs9Tr9+pHcJ6VDRKLdW2bK1lobvB5lSlVkxDB0BV0\noTc1pMIkxD2JcWzblkS76LWMkCJ9+4VqpCwp5hCt7mvgIg==\n-----END CERTIFICATE-----\n".toByteArray()
            )
        )

        Log.d("MainActivity", "keyStore size :${keyStore.size()}")
        val aliases = keyStore.aliases()
        while (aliases.hasMoreElements()) {
            val element = aliases.nextElement()
            Log.d("MainActivity", "keyStore element :$element")
            Log.d("MainActivity", "keyStore certificate\n :${keyStore.getCertificate(element)}")
            Log.d("MainActivity", "keyStore key\n :${keyStore.getKey(element, "".toCharArray())}")
        }
    }
}
