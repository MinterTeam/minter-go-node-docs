MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

BlockChainTransactionRepository repository = MinterBlockChainApi.getInstance().transactions();

Call<BCResult<List<HistoryTransaction>>> request = repository.getTransactions(
        new BlockChainTransactionRepository.TQuery()
                .setFrom("Mx...")
                .setTo("Mx...")
);

request.enqueue(new Callback<BCResult<List<HistoryTransaction>>>() {
    @Override
    public void onResponse(@Nonnull Call<BCResult<List<HistoryTransaction>>> call, @Nonnull Response<BCResult<List<HistoryTransaction>>> response) {
        BCResult<List<HistoryTransaction>> body = response.body();
        if (body.isOk()) {
            // do something with body.result
        } else {
            // handle error
        }
    }

    @Override
    public void onFailure(@Nonnull Call<BCResult<List<HistoryTransaction>>> call, @Nonnull Throwable t) {
        // handle error
    }
});
