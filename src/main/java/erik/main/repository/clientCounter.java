package erik.main.repository;

import erik.main.entity.client;

public class clientCounter {

    private  Long total;
    private client client;

    public clientCounter(Long total, erik.main.entity.client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public erik.main.entity.client getClient() {
        return client;
    }

    public void setClient(erik.main.entity.client client) {
        this.client = client;
    }
}
