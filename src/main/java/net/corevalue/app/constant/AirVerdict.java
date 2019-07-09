package net.corevalue.app.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AirVerdict {
    CO2_EXCEED("CO2 exceed limits"),
    CO2_NORMAL("CO2 within acceptable limits.");

    private String value;
}
