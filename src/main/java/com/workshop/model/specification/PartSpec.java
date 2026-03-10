package com.workshop.model.specification;

import com.workshop.model.enums.PartPrefix;
import com.workshop.model.enums.PartType;
import lombok.Value;

@Value
public class PartSpec {
    PartType partType;
    Class clazz;
    String table;
    PartPrefix prefix;
}
