package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return an empty list when get orders"
    request {
        method 'GET'
        url("/orders")
    }
    response {
        headers {
            header 'Content-Type': 'application/json'
        }
        body('[]')
        status 200
    }
}