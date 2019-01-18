import MinterCore

MinterCoreSDK.initialize(urlString: "https://minter-node-1.testnet.minter.network:8841/")

let manager = StatusManager.default

manager.status(with: { (response, error) in
	print(response)
	print(error)
})
