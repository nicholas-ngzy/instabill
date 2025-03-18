package com.nicholasng.instabill;

import lombok.Builder;

@Builder
class Item {
    String name;
    double price;
    int quantity;
}
