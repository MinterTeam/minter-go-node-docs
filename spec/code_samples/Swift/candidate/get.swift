import MinterCore

MinterCoreSDK.initialize(urlString: "https://minter-node-1.testnet.minter.network:8841/")

let manager = CandidateManager.default

manager.candidate(publicKey: "Mpb52951425d2517504f767215ca77a9be3e0cd788fd72443da9b174fc686a37f0", completion: { (response, error) in
	print(response)
	print(error)
})
