import MinterCore

MinterCoreSDK.initialize(urlString: "https://minter-node-1.testnet.minter.network:8841/")

let manager = BlockManager.default

manager.blocks(height: "1") { blocks, error in
	print(blocks)
	print(error)
}
