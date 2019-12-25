import MinterCore

MinterCoreSDK.initialize(urlString: "https://minter-node-1.testnet.minter.network:8841/")

let manager = TransactionManager.default

manager.estimateCoinSell(from: "MNT", to: "VALIDATOR", amount: Decimal(string: "10000000000")!, completion: { (willPay, commission, error) in
	print(error)
	print(willPay)
	print(commission)
})
