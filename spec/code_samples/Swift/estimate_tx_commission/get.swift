import MinterCore

MinterCoreSDK.initialize(urlString: "https://minter-node-1.testnet.minter.network:8841/")

let manager = TransactionManager.default

let tx = "f88313018a424c41434b434f494e0001aae98a424c41434b434f494e0094228e5a68b847d169da439ec15f727f08233a7ca6883ed6df8a5bc9f6f1808001b845f8431ca02814f29ccc1c1438532d286ce285f3897939281c36da7785ab99f76e2e5f8f91a074acc3624f466302addf4b734eeac4f977179cf1d93f7351cf74c2acda5732f1"

manager.estimateCommission(for: tx, completion: { (comission, error) in
	print(comission)
	print(error)
})
