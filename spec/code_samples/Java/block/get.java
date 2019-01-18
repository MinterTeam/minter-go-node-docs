MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

BlockChainBlockRepository repository = MinterBlockChainApi.getInstance().block();
Call<BCResult<BlockInfo>> request = repository.getByHeight(1);

request.enqueue(new Callback<BCResult<BlockInfo>>() {
    @Override
    public void onResponse(@Nonnull Call<BCResult<BlockInfo>> call, @Nonnull Response<BCResult<BlockInfo>> response) {
        BCResult<BlockInfo> body = response.body();
        if (body.isOk()) {
            // do something with body.result
        } else {
            // handle error
        }
    }

    @Override
    public void onFailure(@Nonnull Call<BCResult<BlockInfo>> call, @Nonnull Throwable t) {
        // handle error
    }
});