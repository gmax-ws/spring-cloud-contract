package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return updated order when update order"
    request {
        method 'PUT'
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
        body '{"id": 100, "description": "Spring Cloud Contact Test"}'
        status 200
    }
}