package com.icure.sdk.crypto.asn

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

@OptIn(ExperimentalStdlibApi::class)
class Asn1Test : StringSpec({
    "Round trip should work" {
        val pkcs1 =
            "30820276020100300d06092a864886f70d0101010500048202603082025c02010002818100a3706a9390eab4091deb4f1d19490488753ac3ac5018976f7ad75c4df1a560310216b4307f943d16e53a4a3ee53d89a886fec4a7fd562de84ccded2af7df68e3edcca5d96aeb1c8eae8d1b30372e07a2332eaad7da6f91450e94660aebe5df97e07b5f0ebe84132442e1849d44bc9e4a51e662b89deedd8c8c9f1c57ccbb8a6d02030100010281803eb343cfb4cab5a2c1bda22e31a317801a291f241dde314a6d3fed83616ee64626dcfae7982a107d961714a0a86541484bf1b5141556586a43fcc43db5b61990aa70b87faddab1a774c9cb5e24c2dbdebfb3dba2c7b82c8e74f835a722e4de8437da55501c10986ad85131c5739f1386d7a54a23c0457ecb494da26ed252bfc1024100d6051aeb01899b09437badad03153e92a69683b6fbee2ad6fe99478a6e0d01f14e32e300882b9187f04c904b05167179cd04ed39ae550f6e27ec0cbbffbbcda5024100c37f6c4c9d0a98927268286abea009f20bae94a960b9c409d04b7da696727adf6257034a5ff696f5497018131075a7d0dfa9ddd5030403c01b030e03fa1c3f29024100d25b1c350642d93686b4a664da15e475c1f548aaeefe0def5939111f17c20339c951acdad5fc74c3374619c112d4175ecf4b5b5b8965239072fec919736784dd0240165e9f3ac9016c61dd7b739c7b417ec1d67a5c826112008f8ae90870a668650ce888c254a1546b03982a9e66980c8e6e45197fcb9ef3b7a624b11dca70b508b90240776e3633f585e980196addeaff011e113790ab5c2ba287b0fbc947974e7f36dd1c0a9578f11184849f37a73066de69f01dff254c1247c7a5eba0c5ec99b9ec13"
        val toAsn1 = pkcs1.hexToByteArray().toAsn1()
        val packed = toAsn1.pack().toHexString()
        packed shouldBe pkcs1
    }

    "From PkCS1 to PKCS8 and back " {
        val pkcs1 =
            "3082025c02010002818100a3706a9390eab4091deb4f1d19490488753ac3ac5018976f7ad75c4df1a560310216b4307f943d16e53a4a3ee53d89a886fec4a7fd562de84ccded2af7df68e3edcca5d96aeb1c8eae8d1b30372e07a2332eaad7da6f91450e94660aebe5df97e07b5f0ebe84132442e1849d44bc9e4a51e662b89deedd8c8c9f1c57ccbb8a6d02030100010281803eb343cfb4cab5a2c1bda22e31a317801a291f241dde314a6d3fed83616ee64626dcfae7982a107d961714a0a86541484bf1b5141556586a43fcc43db5b61990aa70b87faddab1a774c9cb5e24c2dbdebfb3dba2c7b82c8e74f835a722e4de8437da55501c10986ad85131c5739f1386d7a54a23c0457ecb494da26ed252bfc1024100d6051aeb01899b09437badad03153e92a69683b6fbee2ad6fe99478a6e0d01f14e32e300882b9187f04c904b05167179cd04ed39ae550f6e27ec0cbbffbbcda5024100c37f6c4c9d0a98927268286abea009f20bae94a960b9c409d04b7da696727adf6257034a5ff696f5497018131075a7d0dfa9ddd5030403c01b030e03fa1c3f29024100d25b1c350642d93686b4a664da15e475c1f548aaeefe0def5939111f17c20339c951acdad5fc74c3374619c112d4175ecf4b5b5b8965239072fec919736784dd0240165e9f3ac9016c61dd7b739c7b417ec1d67a5c826112008f8ae90870a668650ce888c254a1546b03982a9e66980c8e6e45197fcb9ef3b7a624b11dca70b508b90240776e3633f585e980196addeaff011e113790ab5c2ba287b0fbc947974e7f36dd1c0a9578f11184849f37a73066de69f01dff254c1247c7a5eba0c5ec99b9ec13"
        val asnPkcs1 = pkcs1.hexToByteArray().toAsn1()
        val asnPkcs8 = asnPkcs1.pkcs1ToPkcs8()
        val asnPkcs1_2 = asnPkcs8.pkcs8ToPkcs1()

        asnPkcs1_2.pack().toHexString() shouldBe pkcs1
    }

    "From PkCS8 to PKCS1 and back " {
        val pkcs8 =
            "30820276020100300d06092a864886f70d0101010500048202603082025c02010002818100a3706a9390eab4091deb4f1d19490488753ac3ac5018976f7ad75c4df1a560310216b4307f943d16e53a4a3ee53d89a886fec4a7fd562de84ccded2af7df68e3edcca5d96aeb1c8eae8d1b30372e07a2332eaad7da6f91450e94660aebe5df97e07b5f0ebe84132442e1849d44bc9e4a51e662b89deedd8c8c9f1c57ccbb8a6d02030100010281803eb343cfb4cab5a2c1bda22e31a317801a291f241dde314a6d3fed83616ee64626dcfae7982a107d961714a0a86541484bf1b5141556586a43fcc43db5b61990aa70b87faddab1a774c9cb5e24c2dbdebfb3dba2c7b82c8e74f835a722e4de8437da55501c10986ad85131c5739f1386d7a54a23c0457ecb494da26ed252bfc1024100d6051aeb01899b09437badad03153e92a69683b6fbee2ad6fe99478a6e0d01f14e32e300882b9187f04c904b05167179cd04ed39ae550f6e27ec0cbbffbbcda5024100c37f6c4c9d0a98927268286abea009f20bae94a960b9c409d04b7da696727adf6257034a5ff696f5497018131075a7d0dfa9ddd5030403c01b030e03fa1c3f29024100d25b1c350642d93686b4a664da15e475c1f548aaeefe0def5939111f17c20339c951acdad5fc74c3374619c112d4175ecf4b5b5b8965239072fec919736784dd0240165e9f3ac9016c61dd7b739c7b417ec1d67a5c826112008f8ae90870a668650ce888c254a1546b03982a9e66980c8e6e45197fcb9ef3b7a624b11dca70b508b90240776e3633f585e980196addeaff011e113790ab5c2ba287b0fbc947974e7f36dd1c0a9578f11184849f37a73066de69f01dff254c1247c7a5eba0c5ec99b9ec13"
        val asnPkcs8 = pkcs8.hexToByteArray().toAsn1()
        val asnPkcs1 = asnPkcs8.pkcs8ToPkcs1()
        val asnPkcs8_2 = asnPkcs1.pkcs1ToPkcs8()

        asnPkcs8_2.pack().toHexString() shouldBe pkcs8
    }

    "From PKCS1 to SPKI and back" {
        val pkcs1 =
            "3082010a0282010100b24473a3ac83557e3de6914e9511658c06447e38f4f5973d677fce7a900996cdc359d635ef5143d15d54caf21d8b25ced26b93bf6ee11de2595d5856506135141caf0ec2bca8560815e3ba2988e546afb06c17bb024f23e7ca11c0dd4107e216d1fc43b0179d6dce0a2de650e30d120602f40a6ca868b5fbeaa654fb6ed23b091048559c57ffa09df0c7b3e3d1f7e0dec7dfe21941633e36e4e67116e14003107128ceb289fa4b96ea45f9726b3e818dd24b3e48ab362d6bf8d308adc0cc7d813bf820441ccc2fe87e443eec019cf0bc0b450b31a89617d03748ea9164193cb5b1e6ffa635aabf404775b9fde6f1a29327195386da69cb80df8c5d1c54c7b9a90203010001"
        val asnPkcs1 = pkcs1.hexToByteArray().toAsn1()
        val asnSpki = asnPkcs1.pkcs1ToSpki()
        val asnPkcs1_2 = asnSpki.spkiToPkcs1()

        asnPkcs1_2.pack().toHexString() shouldBe pkcs1
    }

    "From SPKI to PKCS1 and back" {
        val spki =
            "30820122300d06092a864886f70d01010105000382010f003082010a0282010100b24473a3ac83557e3de6914e9511658c06447e38f4f5973d677fce7a900996cdc359d635ef5143d15d54caf21d8b25ced26b93bf6ee11de2595d5856506135141caf0ec2bca8560815e3ba2988e546afb06c17bb024f23e7ca11c0dd4107e216d1fc43b0179d6dce0a2de650e30d120602f40a6ca868b5fbeaa654fb6ed23b091048559c57ffa09df0c7b3e3d1f7e0dec7dfe21941633e36e4e67116e14003107128ceb289fa4b96ea45f9726b3e818dd24b3e48ab362d6bf8d308adc0cc7d813bf820441ccc2fe87e443eec019cf0bc0b450b31a89617d03748ea9164193cb5b1e6ffa635aabf404775b9fde6f1a29327195386da69cb80df8c5d1c54c7b9a90203010001"
        val asnSpki = spki.hexToByteArray().toAsn1()
        val asnPkcs1 = asnSpki.spkiToPkcs1()
        val asnPkSpki_2 = asnPkcs1.pkcs1ToSpki()

        asnPkSpki_2.pack().toHexString() shouldBe spki
    }

    "String.hexToByteArray() should convert hexadecimal string to byte array correctly" {
        "01020f".hexToByteArray() shouldBe byteArrayOf(0x01, 0x02, 0x0F)
        "".hexToByteArray() shouldBe byteArrayOf()
        // more test cases...
    }

    "ByteArray.toAsn1() should parse ASN.1 PKCS1 public key correctly" {
        val asn1Data = "3048024100a8f7e069311610fdd2f70d2d82c89c5117e8fa72d6d3dff429f38f8a7858678a2ecd4fb7c42e294a5129f14b7d1602f4020a8db2535a2b7e0aabe3598cef43010203010001".hexToByteArray()
        val asn1 = asn1Data.toAsn1()

        asn1.shouldBeInstanceOf<Asn1Object.Asn1Sequence>().let {
            it.value.size shouldBe 2
            it.value[1].shouldBeInstanceOf<Asn1Object.Asn1Integer>().let {
                it.value.toLong() shouldBe 65537
            }
        }
    }

    "ByteArray.toAsn1() should parse ASN.1 PKCS8 embeded octet string" {
        val asn1Data = "3082025c02010002818100a3706a9390eab4091deb4f1d19490488753ac3ac5018976f7ad75c4df1a560310216b4307f943d16e53a4a3ee53d89a886fec4a7fd562de84ccded2af7df68e3edcca5d96aeb1c8eae8d1b30372e07a2332eaad7da6f91450e94660aebe5df97e07b5f0ebe84132442e1849d44bc9e4a51e662b89deedd8c8c9f1c57ccbb8a6d02030100010281803eb343cfb4cab5a2c1bda22e31a317801a291f241dde314a6d3fed83616ee64626dcfae7982a107d961714a0a86541484bf1b5141556586a43fcc43db5b61990aa70b87faddab1a774c9cb5e24c2dbdebfb3dba2c7b82c8e74f835a722e4de8437da55501c10986ad85131c5739f1386d7a54a23c0457ecb494da26ed252bfc1024100d6051aeb01899b09437badad03153e92a69683b6fbee2ad6fe99478a6e0d01f14e32e300882b9187f04c904b05167179cd04ed39ae550f6e27ec0cbbffbbcda5024100c37f6c4c9d0a98927268286abea009f20bae94a960b9c409d04b7da696727adf6257034a5ff696f5497018131075a7d0dfa9ddd5030403c01b030e03fa1c3f29024100d25b1c350642d93686b4a664da15e475c1f548aaeefe0def5939111f17c20339c951acdad5fc74c3374619c112d4175ecf4b5b5b8965239072fec919736784dd0240165e9f3ac9016c61dd7b739c7b417ec1d67a5c826112008f8ae90870a668650ce888c254a1546b03982a9e66980c8e6e45197fcb9ef3b7a624b11dca70b508b90240776e3633f585e980196addeaff011e113790ab5c2ba287b0fbc947974e7f36dd1c0a9578f11184849f37a73066de69f01dff254c1247c7a5eba0c5ec99b9ec13".hexToByteArray()
        val asn1 = asn1Data.toAsn1()

        asn1.shouldBeInstanceOf<Asn1Object.Asn1Sequence>().let {
            it.value.size shouldBe 9
            it.value[2].shouldBeInstanceOf<Asn1Object.Asn1Integer>().let {
                it.value.toLong() shouldBe 65537
            }
        }
    }

    "ByteArray.toAsn1() should parse ASN.1 PKCS8 public key correctly" {
        val asn1Data = "30820276020100300d06092a864886f70d0101010500048202603082025c02010002818100a3706a9390eab4091deb4f1d19490488753ac3ac5018976f7ad75c4df1a560310216b4307f943d16e53a4a3ee53d89a886fec4a7fd562de84ccded2af7df68e3edcca5d96aeb1c8eae8d1b30372e07a2332eaad7da6f91450e94660aebe5df97e07b5f0ebe84132442e1849d44bc9e4a51e662b89deedd8c8c9f1c57ccbb8a6d02030100010281803eb343cfb4cab5a2c1bda22e31a317801a291f241dde314a6d3fed83616ee64626dcfae7982a107d961714a0a86541484bf1b5141556586a43fcc43db5b61990aa70b87faddab1a774c9cb5e24c2dbdebfb3dba2c7b82c8e74f835a722e4de8437da55501c10986ad85131c5739f1386d7a54a23c0457ecb494da26ed252bfc1024100d6051aeb01899b09437badad03153e92a69683b6fbee2ad6fe99478a6e0d01f14e32e300882b9187f04c904b05167179cd04ed39ae550f6e27ec0cbbffbbcda5024100c37f6c4c9d0a98927268286abea009f20bae94a960b9c409d04b7da696727adf6257034a5ff696f5497018131075a7d0dfa9ddd5030403c01b030e03fa1c3f29024100d25b1c350642d93686b4a664da15e475c1f548aaeefe0def5939111f17c20339c951acdad5fc74c3374619c112d4175ecf4b5b5b8965239072fec919736784dd0240165e9f3ac9016c61dd7b739c7b417ec1d67a5c826112008f8ae90870a668650ce888c254a1546b03982a9e66980c8e6e45197fcb9ef3b7a624b11dca70b508b90240776e3633f585e980196addeaff011e113790ab5c2ba287b0fbc947974e7f36dd1c0a9578f11184849f37a73066de69f01dff254c1247c7a5eba0c5ec99b9ec13".hexToByteArray()
        val asn1 = asn1Data.toAsn1()

        asn1.shouldBeInstanceOf<Asn1Object.Asn1Sequence>()
        asn1.value.size shouldBe 3
        asn1.value[0].shouldBeInstanceOf<Asn1Object.Asn1Integer>()
        asn1.value[1].shouldBeInstanceOf<Asn1Object.Asn1Sequence>()
        asn1.value[2].shouldBeInstanceOf<Asn1Object.Asn1OctetString>().let {
            it.nested.shouldBeInstanceOf<Asn1Object.Asn1Sequence>().let {
                it.value.size shouldBe 9
                it.value[2].shouldBeInstanceOf<Asn1Object.Asn1Integer>().let {
                    it.value.toLong() shouldBe 65537
                }
            }
        }
    }

    "Asn1 integer should be packed correctly" {
        Asn1Object.Asn1Integer("00a3706a9390eab4091deb4f1d19490488753ac3ac5018976f7ad75c4df1a560310216b4307f943d16e53a4a3ee53d89a886fec4a7fd562de84ccded2af7df68e3edcca5d96aeb1c8eae8d1b30372e07a2332eaad7da6f91450e94660aebe5df97e07b5f0ebe84132442e1849d44bc9e4a51e662b89deedd8c8c9f1c57ccbb8a6d".hexToByteArray())
            .pack()
            .toHexString() shouldBe "02818100a3706a9390eab4091deb4f1d19490488753ac3ac5018976f7ad75c4df1a560310216b4307f943d16e53a4a3ee53d89a886fec4a7fd562de84ccded2af7df68e3edcca5d96aeb1c8eae8d1b30372e07a2332eaad7da6f91450e94660aebe5df97e07b5f0ebe84132442e1849d44bc9e4a51e662b89deedd8c8c9f1c57ccbb8a6d"
        Asn1Object.Asn1Integer("3eb343cfb4cab5a2c1bda22e31a317801a291f241dde314a6d3fed83616ee64626dcfae7982a107d961714a0a86541484bf1b5141556586a43fcc43db5b61990aa70b87faddab1a774c9cb5e24c2dbdebfb3dba2c7b82c8e74f835a722e4de8437da55501c10986ad85131c5739f1386d7a54a23c0457ecb494da26ed252bfc1".hexToByteArray())
            .pack()
            .toHexString() shouldBe "0281803eb343cfb4cab5a2c1bda22e31a317801a291f241dde314a6d3fed83616ee64626dcfae7982a107d961714a0a86541484bf1b5141556586a43fcc43db5b61990aa70b87faddab1a774c9cb5e24c2dbdebfb3dba2c7b82c8e74f835a722e4de8437da55501c10986ad85131c5739f1386d7a54a23c0457ecb494da26ed252bfc1"
    }


    "Integer.toAsn1() should pack" {
        val zero = 0.toByteArray()
        Asn1Object.Asn1Integer(zero)
            .pack().toHexString() shouldBe "020100"
    }




    "Sequense of Integer.toAsn1() should pack" {
        Asn1Object.Asn1Sequence(
            listOf(
                Asn1Object.Asn1Integer(0.toByteArray()),
                Asn1Object.Asn1Integer(65537.toByteArray())
            )
        ).pack().toHexString() shouldBe "30080201000203010001"
    }


    "ByteArray.toAsn1() should pack ASN.1 PKCS8 embedded octet string" {
        Asn1Object.Asn1Sequence(
            listOf(
                Asn1Object.Asn1Integer(0.toByteArray()),
                Asn1Object.Asn1Integer("00a3706a9390eab4091deb4f1d19490488753ac3ac5018976f7ad75c4df1a560310216b4307f943d16e53a4a3ee53d89a886fec4a7fd562de84ccded2af7df68e3edcca5d96aeb1c8eae8d1b30372e07a2332eaad7da6f91450e94660aebe5df97e07b5f0ebe84132442e1849d44bc9e4a51e662b89deedd8c8c9f1c57ccbb8a6d".hexToByteArray()),
                Asn1Object.Asn1Integer(65537.toByteArray()),
                Asn1Object.Asn1Integer("3eb343cfb4cab5a2c1bda22e31a317801a291f241dde314a6d3fed83616ee64626dcfae7982a107d961714a0a86541484bf1b5141556586a43fcc43db5b61990aa70b87faddab1a774c9cb5e24c2dbdebfb3dba2c7b82c8e74f835a722e4de8437da55501c10986ad85131c5739f1386d7a54a23c0457ecb494da26ed252bfc1".hexToByteArray()),
                Asn1Object.Asn1Integer("00d6051aeb01899b09437badad03153e92a69683b6fbee2ad6fe99478a6e0d01f14e32e300882b9187f04c904b05167179cd04ed39ae550f6e27ec0cbbffbbcda5".hexToByteArray()),
                Asn1Object.Asn1Integer("00c37f6c4c9d0a98927268286abea009f20bae94a960b9c409d04b7da696727adf6257034a5ff696f5497018131075a7d0dfa9ddd5030403c01b030e03fa1c3f29".hexToByteArray()),
                Asn1Object.Asn1Integer("00d25b1c350642d93686b4a664da15e475c1f548aaeefe0def5939111f17c20339c951acdad5fc74c3374619c112d4175ecf4b5b5b8965239072fec919736784dd".hexToByteArray()),
                Asn1Object.Asn1Integer("165e9f3ac9016c61dd7b739c7b417ec1d67a5c826112008f8ae90870a668650ce888c254a1546b03982a9e66980c8e6e45197fcb9ef3b7a624b11dca70b508b9".hexToByteArray()),
                Asn1Object.Asn1Integer("776e3633f585e980196addeaff011e113790ab5c2ba287b0fbc947974e7f36dd1c0a9578f11184849f37a73066de69f01dff254c1247c7a5eba0c5ec99b9ec13".hexToByteArray())
            )
        ).pack()
            .toHexString() shouldBe "3082025c02010002818100a3706a9390eab4091deb4f1d19490488753ac3ac5018976f7ad75c4df1a560310216b4307f943d16e53a4a3ee53d89a886fec4a7fd562de84ccded2af7df68e3edcca5d96aeb1c8eae8d1b30372e07a2332eaad7da6f91450e94660aebe5df97e07b5f0ebe84132442e1849d44bc9e4a51e662b89deedd8c8c9f1c57ccbb8a6d02030100010281803eb343cfb4cab5a2c1bda22e31a317801a291f241dde314a6d3fed83616ee64626dcfae7982a107d961714a0a86541484bf1b5141556586a43fcc43db5b61990aa70b87faddab1a774c9cb5e24c2dbdebfb3dba2c7b82c8e74f835a722e4de8437da55501c10986ad85131c5739f1386d7a54a23c0457ecb494da26ed252bfc1024100d6051aeb01899b09437badad03153e92a69683b6fbee2ad6fe99478a6e0d01f14e32e300882b9187f04c904b05167179cd04ed39ae550f6e27ec0cbbffbbcda5024100c37f6c4c9d0a98927268286abea009f20bae94a960b9c409d04b7da696727adf6257034a5ff696f5497018131075a7d0dfa9ddd5030403c01b030e03fa1c3f29024100d25b1c350642d93686b4a664da15e475c1f548aaeefe0def5939111f17c20339c951acdad5fc74c3374619c112d4175ecf4b5b5b8965239072fec919736784dd0240165e9f3ac9016c61dd7b739c7b417ec1d67a5c826112008f8ae90870a668650ce888c254a1546b03982a9e66980c8e6e45197fcb9ef3b7a624b11dca70b508b90240776e3633f585e980196addeaff011e113790ab5c2ba287b0fbc947974e7f36dd1c0a9578f11184849f37a73066de69f01dff254c1247c7a5eba0c5ec99b9ec13"
    }

    "ByteArray.toAsn1() should pack ASN.1 PKCS8 public key correctly" {
        val res = Asn1Object.Asn1Sequence(
            listOf(
                Asn1Object.Asn1Integer(0.toByteArray()),
                Asn1Object.Asn1Sequence(
                    listOf(
                        Asn1Object.Asn1Oid("1.2.840.113549.1.1.1"),
                        Asn1Object.Asn1Null()
                    )
                ),
                Asn1Object.Asn1OctetString(
                    Asn1Object.Asn1Sequence(
                        listOf(
                            Asn1Object.Asn1Integer(0.toByteArray()),
                            Asn1Object.Asn1Integer("00a3706a9390eab4091deb4f1d19490488753ac3ac5018976f7ad75c4df1a560310216b4307f943d16e53a4a3ee53d89a886fec4a7fd562de84ccded2af7df68e3edcca5d96aeb1c8eae8d1b30372e07a2332eaad7da6f91450e94660aebe5df97e07b5f0ebe84132442e1849d44bc9e4a51e662b89deedd8c8c9f1c57ccbb8a6d".hexToByteArray()),
                            Asn1Object.Asn1Integer(65537.toByteArray()),
                            Asn1Object.Asn1Integer("3eb343cfb4cab5a2c1bda22e31a317801a291f241dde314a6d3fed83616ee64626dcfae7982a107d961714a0a86541484bf1b5141556586a43fcc43db5b61990aa70b87faddab1a774c9cb5e24c2dbdebfb3dba2c7b82c8e74f835a722e4de8437da55501c10986ad85131c5739f1386d7a54a23c0457ecb494da26ed252bfc1".hexToByteArray()),
                            Asn1Object.Asn1Integer("00d6051aeb01899b09437badad03153e92a69683b6fbee2ad6fe99478a6e0d01f14e32e300882b9187f04c904b05167179cd04ed39ae550f6e27ec0cbbffbbcda5".hexToByteArray()),
                            Asn1Object.Asn1Integer("00c37f6c4c9d0a98927268286abea009f20bae94a960b9c409d04b7da696727adf6257034a5ff696f5497018131075a7d0dfa9ddd5030403c01b030e03fa1c3f29".hexToByteArray()),
                            Asn1Object.Asn1Integer("00d25b1c350642d93686b4a664da15e475c1f548aaeefe0def5939111f17c20339c951acdad5fc74c3374619c112d4175ecf4b5b5b8965239072fec919736784dd".hexToByteArray()),
                            Asn1Object.Asn1Integer("165e9f3ac9016c61dd7b739c7b417ec1d67a5c826112008f8ae90870a668650ce888c254a1546b03982a9e66980c8e6e45197fcb9ef3b7a624b11dca70b508b9".hexToByteArray()),
                            Asn1Object.Asn1Integer("776e3633f585e980196addeaff011e113790ab5c2ba287b0fbc947974e7f36dd1c0a9578f11184849f37a73066de69f01dff254c1247c7a5eba0c5ec99b9ec13".hexToByteArray())
                        )
                    ).pack()
                )
            )
        ).pack()
            .toHexString()
        res shouldBe "30820276020100300d06092a864886f70d0101010500048202603082025c02010002818100a3706a9390eab4091deb4f1d19490488753ac3ac5018976f7ad75c4df1a560310216b4307f943d16e53a4a3ee53d89a886fec4a7fd562de84ccded2af7df68e3edcca5d96aeb1c8eae8d1b30372e07a2332eaad7da6f91450e94660aebe5df97e07b5f0ebe84132442e1849d44bc9e4a51e662b89deedd8c8c9f1c57ccbb8a6d02030100010281803eb343cfb4cab5a2c1bda22e31a317801a291f241dde314a6d3fed83616ee64626dcfae7982a107d961714a0a86541484bf1b5141556586a43fcc43db5b61990aa70b87faddab1a774c9cb5e24c2dbdebfb3dba2c7b82c8e74f835a722e4de8437da55501c10986ad85131c5739f1386d7a54a23c0457ecb494da26ed252bfc1024100d6051aeb01899b09437badad03153e92a69683b6fbee2ad6fe99478a6e0d01f14e32e300882b9187f04c904b05167179cd04ed39ae550f6e27ec0cbbffbbcda5024100c37f6c4c9d0a98927268286abea009f20bae94a960b9c409d04b7da696727adf6257034a5ff696f5497018131075a7d0dfa9ddd5030403c01b030e03fa1c3f29024100d25b1c350642d93686b4a664da15e475c1f548aaeefe0def5939111f17c20339c951acdad5fc74c3374619c112d4175ecf4b5b5b8965239072fec919736784dd0240165e9f3ac9016c61dd7b739c7b417ec1d67a5c826112008f8ae90870a668650ce888c254a1546b03982a9e66980c8e6e45197fcb9ef3b7a624b11dca70b508b90240776e3633f585e980196addeaff011e113790ab5c2ba287b0fbc947974e7f36dd1c0a9578f11184849f37a73066de69f01dff254c1247c7a5eba0c5ec99b9ec13"
    }
})