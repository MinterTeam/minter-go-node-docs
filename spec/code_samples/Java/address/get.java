MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

BlockChainAccountRepository repository = MinterBlockChainApi.getInstance().account();
Call<BCResult<Balance>> request = repository.getBalance("Mx618ed05277e7568ee943cd1b8e22ced4cf873f95");

request.enqueue(new Callback<BCResult<Balance>>() {
    @Override
    public void onResponse(@Nonnull Call<BCResult<Balance>> call, @Nonnull Response<BCResult<Balance>> response) {
        BCResult<Balance> body = response.body();
        if (body.isOk()) {
            // do something with body.result
        } else {
            // handle error
        }
    }

    @Override
    public void onFailure(@Nonnull Call<BCResult<Balance>> call, @Nonnull Throwable t) {
        // handle error
    }
});