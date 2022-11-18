package com.task.currency.data.remote

data class SymbolsResponse(
    val success: Boolean, // true
    val symbols: Symbols
) {
    data class Symbols(
        val AED: String, // United Arab Emirates Dirham
        val AFN: String, // Afghan Afghani
        val ALL: String, // Albanian Lek
        val AMD: String, // Armenian Dram
        val ANG: String, // Netherlands Antillean Guilder
        val AOA: String, // Angolan Kwanza
        val ARS: String, // Argentine Peso
        val AUD: String, // Australian Dollar
        val AWG: String, // Aruban Florin
        val AZN: String, // Azerbaijani Manat
        val BAM: String, // Bosnia-Herzegovina Convertible Mark
        val BBD: String, // Barbadian Dollar
        val BDT: String, // Bangladeshi Taka
        val BGN: String, // Bulgarian Lev
        val BHD: String, // Bahraini Dinar
        val BIF: String, // Burundian Franc
        val BMD: String, // Bermudan Dollar
        val BND: String, // Brunei Dollar
        val BOB: String, // Bolivian Boliviano
        val BRL: String, // Brazilian Real
        val BSD: String, // Bahamian Dollar
        val BTC: String, // Bitcoin
        val BTN: String, // Bhutanese Ngultrum
        val BWP: String, // Botswanan Pula
        val BYN: String, // New Belarusian Ruble
        val BYR: String, // Belarusian Ruble
        val BZD: String, // Belize Dollar
        val CAD: String, // Canadian Dollar
        val CDF: String, // Congolese Franc
        val CHF: String, // Swiss Franc
        val CLF: String, // Chilean Unit of Account (UF)
        val CLP: String, // Chilean Peso
        val CNY: String, // Chinese Yuan
        val COP: String, // Colombian Peso
        val CRC: String, // Costa Rican Colón
        val CUC: String, // Cuban Convertible Peso
        val CUP: String, // Cuban Peso
        val CVE: String, // Cape Verdean Escudo
        val CZK: String, // Czech Republic Koruna
        val DJF: String, // Djiboutian Franc
        val DKK: String, // Danish Krone
        val DOP: String, // Dominican Peso
        val DZD: String, // Algerian Dinar
        val EGP: String, // Egyptian Pound
        val ERN: String, // Eritrean Nakfa
        val ETB: String, // Ethiopian Birr
        val EUR: String, // Euro
        val FJD: String, // Fijian Dollar
        val FKP: String, // Falkland Islands Pound
        val GBP: String, // British Pound Sterling
        val GEL: String, // Georgian Lari
        val GGP: String, // Guernsey Pound
        val GHS: String, // Ghanaian Cedi
        val GIP: String, // Gibraltar Pound
        val GMD: String, // Gambian Dalasi
        val GNF: String, // Guinean Franc
        val GTQ: String, // Guatemalan Quetzal
        val GYD: String, // Guyanaese Dollar
        val HKD: String, // Hong Kong Dollar
        val HNL: String, // Honduran Lempira
        val HRK: String, // Croatian Kuna
        val HTG: String, // Haitian Gourde
        val HUF: String, // Hungarian Forint
        val IDR: String, // Indonesian Rupiah
        val ILS: String, // Israeli New Sheqel
        val IMP: String, // Manx pound
        val INR: String, // Indian Rupee
        val IQD: String, // Iraqi Dinar
        val IRR: String, // Iranian Rial
        val ISK: String, // Icelandic Króna
        val JEP: String, // Jersey Pound
        val JMD: String, // Jamaican Dollar
        val JOD: String, // Jordanian Dinar
        val JPY: String, // Japanese Yen
        val KES: String, // Kenyan Shilling
        val KGS: String, // Kyrgystani Som
        val KHR: String, // Cambodian Riel
        val KMF: String, // Comorian Franc
        val KPW: String, // North Korean Won
        val KRW: String, // South Korean Won
        val KWD: String, // Kuwaiti Dinar
        val KYD: String, // Cayman Islands Dollar
        val KZT: String, // Kazakhstani Tenge
        val LAK: String, // Laotian Kip
        val LBP: String, // Lebanese Pound
        val LKR: String, // Sri Lankan Rupee
        val LRD: String, // Liberian Dollar
        val LSL: String, // Lesotho Loti
        val LTL: String, // Lithuanian Litas
        val LVL: String, // Latvian Lats
        val LYD: String, // Libyan Dinar
        val MAD: String, // Moroccan Dirham
        val MDL: String, // Moldovan Leu
        val MGA: String, // Malagasy Ariary
        val MKD: String, // Macedonian Denar
        val MMK: String, // Myanma Kyat
        val MNT: String, // Mongolian Tugrik
        val MOP: String, // Macanese Pataca
        val MRO: String, // Mauritanian Ouguiya
        val MUR: String, // Mauritian Rupee
        val MVR: String, // Maldivian Rufiyaa
        val MWK: String, // Malawian Kwacha
        val MXN: String, // Mexican Peso
        val MYR: String, // Malaysian Ringgit
        val MZN: String, // Mozambican Metical
        val NAD: String, // Namibian Dollar
        val NGN: String, // Nigerian Naira
        val NIO: String, // Nicaraguan Córdoba
        val NOK: String, // Norwegian Krone
        val NPR: String, // Nepalese Rupee
        val NZD: String, // New Zealand Dollar
        val OMR: String, // Omani Rial
        val PAB: String, // Panamanian Balboa
        val PEN: String, // Peruvian Nuevo Sol
        val PGK: String, // Papua New Guinean Kina
        val PHP: String, // Philippine Peso
        val PKR: String, // Pakistani Rupee
        val PLN: String, // Polish Zloty
        val PYG: String, // Paraguayan Guarani
        val QAR: String, // Qatari Rial
        val RON: String, // Romanian Leu
        val RSD: String, // Serbian Dinar
        val RUB: String, // Russian Ruble
        val RWF: String, // Rwandan Franc
        val SAR: String, // Saudi Riyal
        val SBD: String, // Solomon Islands Dollar
        val SCR: String, // Seychellois Rupee
        val SDG: String, // Sudanese Pound
        val SEK: String, // Swedish Krona
        val SGD: String, // Singapore Dollar
        val SHP: String, // Saint Helena Pound
        val SLE: String, // Sierra Leonean Leone
        val SLL: String, // Sierra Leonean Leone
        val SOS: String, // Somali Shilling
        val SRD: String, // Surinamese Dollar
        val STD: String, // São Tomé and Príncipe Dobra
        val SVC: String, // Salvadoran Colón
        val SYP: String, // Syrian Pound
        val SZL: String, // Swazi Lilangeni
        val THB: String, // Thai Baht
        val TJS: String, // Tajikistani Somoni
        val TMT: String, // Turkmenistani Manat
        val TND: String, // Tunisian Dinar
        val TOP: String, // Tongan Paʻanga
        val TRY: String, // Turkish Lira
        val TTD: String, // Trinidad and Tobago Dollar
        val TWD: String, // New Taiwan Dollar
        val TZS: String, // Tanzanian Shilling
        val UAH: String, // Ukrainian Hryvnia
        val UGX: String, // Ugandan Shilling
        val USD: String, // United States Dollar
        val UYU: String, // Uruguayan Peso
        val UZS: String, // Uzbekistan Som
        val VEF: String, // Venezuelan Bolívar Fuerte
        val VND: String, // Vietnamese Dong
        val VUV: String, // Vanuatu Vatu
        val WST: String, // Samoan Tala
        val XAF: String, // CFA Franc BEAC
        val XAG: String, // Silver (troy ounce)
        val XAU: String, // Gold (troy ounce)
        val XCD: String, // East Caribbean Dollar
        val XDR: String, // Special Drawing Rights
        val XOF: String, // CFA Franc BCEAO
        val XPF: String, // CFP Franc
        val YER: String, // Yemeni Rial
        val ZAR: String, // South African Rand
        val ZMK: String, // Zambian Kwacha (pre-2013)
        val ZMW: String, // Zambian Kwacha
        val ZWL: String // Zimbabwean Dollar
    )
}