import MinterCore

MinterCoreSDK.initialize(urlString: "https://minter-node-1.testnet.minter.network:8841/")

let manager = CoinManager.default

self.manager?.info(symbol: "TESTCOIN", completion: { (coin, error) in
	print(coin)
	print(error)
})
