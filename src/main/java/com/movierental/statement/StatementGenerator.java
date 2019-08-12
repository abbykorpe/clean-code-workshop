package com.movierental.statement;

import com.movierental.Customer;

public interface StatementGenerator {
    String generate(Customer customer);
}
