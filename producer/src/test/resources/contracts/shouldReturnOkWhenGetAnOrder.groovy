package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return OK when get an order"
    request {
        method 'GET'
        url("/order/2")
    }
    response {
        headers {
            header 'Content-Type': 'application/json'
        }
        body('{"id": 2, "description": "order 2"}')
        status 200
    }
}