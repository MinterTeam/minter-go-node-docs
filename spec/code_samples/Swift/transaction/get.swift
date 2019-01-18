import MinterCore

MinterCoreSDK.initialize(urlString: "https://minter-node-1.testnet.minter.network:8841/")

let manager = TransactionManager.default

manager.transaction(hash: "Mtb181f0185dfbda5f6ed497581dce1bf4cbac2a427374bf45018343c7af6471b8", completion: { (transaction, error) in
	print(transaction)
	print(error)
})
