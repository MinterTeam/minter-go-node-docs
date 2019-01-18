import MinterCore

MinterCoreSDK.initialize(urlString: "https://minter-node-1.testnet.minter.network:8841/")

let manager = CandidateManager.default

manager.candidates(height: "1", completion: { (response, error) in
	print(response)
	print(error)
})
