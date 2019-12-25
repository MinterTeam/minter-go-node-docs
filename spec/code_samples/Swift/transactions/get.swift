import MinterCore

MinterCoreSDK.initialize(urlString: "https://minter-node-1.testnet.minter.network:8841/")

let manager = TransactionManager.default

manager.transactions(query: "query here", completion: { (transactions, error) in
	print(transactions)
	print(error)
})
