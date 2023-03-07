package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return deleted order when delete order"
    request {
        method 'DELETE'
        url("/order/100")
    }
    response {
        headers {
            header 'Content-Type': 'application/json'
        }
        body '{"id": 100, "description": "order 100"}'
        status 200
    }
}