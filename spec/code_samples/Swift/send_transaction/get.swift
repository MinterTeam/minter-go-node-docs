import MinterCore

MinterCoreSDK.initialize(urlString: "https://minter-node-1.testnet.minter.network:8841/")

let manager = TransactionManager.default

let tx = DeclareCandidacyRawTransaction(nonce: BigUInt(1), gasCoin: "MNT", address: "MxAddress", publicKey: "MpPublicKey", commission: BigUInt(decimal: 10.0)!, coin: "MNT", stake: BigUInt(decimal: 100.0)!)

let signed = RawTransactionSigner.sign(rawTx: tx, privateKey: "Private Key String Here")

manager.send(tx: signed!) { (res, res1, error) in
	
}
