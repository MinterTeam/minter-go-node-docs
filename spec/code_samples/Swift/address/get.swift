
import MinterCore

MinterCoreSDK.initialize(urlString: "https://minter-node-1.testnet.minter.network:8841/api/")

let accountManager = AccountManager.default

accountManager.address("Mx618ed05277e7568ee943cd1b8e22ced4cf873f95") { [weak self] (resp, error) in
	print(resp)
	print(error)
}
