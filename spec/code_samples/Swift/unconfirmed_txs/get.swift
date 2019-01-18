import MinterCore

MinterCoreSDK.initialize(urlString: "https://minter-node-1.testnet.minter.network:8841/")

let manager = TransactionManager.default

manager.unconfirmedTransactions(height: "0", completion: { (transactions, error) in
	print(transactions)
	print(error)
})
