This app work with Google Play Services `20.26.14 (120700-320008519)` and `20.33.15 (100408ｰ330018294)`.
But if with `20.36.15 (100400-333172415)` app will crash. 

This may be caused by latest Google Play Services check strictly X.509 certification.
Our certification was v1 and had X.509 v3extensions.

I suspect that our certification fail checking line at https://boringssl.googlesource.com/boringssl/+/de196121b05adea2f9b7e400271266495a40b0f4/crypto/x509/x_x509.c#139
