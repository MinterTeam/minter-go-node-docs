MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

BlockChainEventRepository repository = MinterBlockChainApi.getInstance().event();

long blockHeight = 1;
Call<BCResult<EventList>> request = repository.getEvents(blockHeight);

request.enqueue(new Callback<BCResult<EventList>>() {
    @Override
    public void onResponse(@Nonnull Call<BCResult<EventList>> call, @Nonnull Response<BCResult<EventList>> response) {
        BCResult<EventList> body = response.body();
        if (body.isOk()) {
            // EventList.RewardEvent event = body.result.events.get(0).getValue();
            // EventList.SlashEvent event = body.result.events.get(1).getValue();
            // do something with body.result
        } else {
            // handle error
        }
    }

    @Override
    public void onFailure(@Nonnull Call<BCResult<EventList>> call, @Nonnull Throwable t) {
        // handle error
    }
});