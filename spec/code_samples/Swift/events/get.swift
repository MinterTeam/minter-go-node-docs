import MinterCore

MinterCoreSDK.initialize(urlString: "https://minter-node-1.testnet.minter.network:8841/")

let manager = EventManager.default

manager.events(height: "1") { events, error in
	print(events)
	print(error)
}
