MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

BlockChainStatusRepository repository = MinterBlockChainApi.getInstance().status();

Call<BCResult<NetworkStatus>> request = repository.getNetworkStatus();

request.enqueue(new Callback<BCResult<NetworkStatus>>() {
    @Override
    public void onResponse(@Nonnull Call<BCResult<NetworkStatus>> call, @Nonnull Response<BCResult<NetworkStatus>> response) {
        BCResult<NetworkStatus> body = response.body();
        if (body.isOk()) {
            // do something with body.result
        } else {
            // handle error
        }
    }

    @Override
    public void onFailure(@Nonnull Call<BCResult<NetworkStatus>> call, @Nonnull Throwable t) {
        // handle error
    }
});
