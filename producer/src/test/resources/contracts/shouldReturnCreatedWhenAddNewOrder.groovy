package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return created on new order"
    request {
        method 'POST'
        url("/order")
        headers {
            header 'Content-Type': 'application/json'
        }
        body '{"id": 100, "description": "Laptop Dell Latitude 5330"}'
    }
    response {
        headers {
            header 'Content-Type': 'application/json'
        }
        body('{"id": 100, "description": "Laptop Dell Latitude 5330"}')
        status 201
    }
}