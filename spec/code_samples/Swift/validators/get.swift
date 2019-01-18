import MinterCore

MinterCoreSDK.initialize(urlString: "https://minter-node-1.testnet.minter.network:8841/")

let manager = ValidatorManager.default

manager.validators(with: { (validators, error) in
	print(validators)
	print(error)
})
