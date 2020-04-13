package com.nure;

import com.nure.model.*;
import com.nure.model.comparator.BatteryCapacityComparator;
import com.nure.model.comparator.ScreenDiagonalComparator;

import java.util.Arrays;

public class App {


    public static void main(String[] args) throws InterruptedException {
        Phone smartPhone = new SmartPhone("Samsung", "Galaxy M31", 7499, 6.4f, 3000, SmartPhone.ScreenType.AMOLED, true);
        Phone pushButtonPhone = new PushButtonPhone("RIM", "BlackBerry Bold 9900", 1200, 2.5f, 3500, PushButtonPhone.KeyboardType.QWERTY, PushButtonPhone.BodyType.STANDARD);
        Phone officePhone = new OfficePhone("Panasonic", "KX-TG1612UAH", 1599, OfficePhone.HandSetType.WIRELESS, false);

        Phone[] phones = new Phone[]{smartPhone, pushButtonPhone, officePhone};
        MobilePhone[] mobilePhones = new MobilePhone[]{(MobilePhone) smartPhone, (MobilePhone) pushButtonPhone};

        BatteryCapacityComparator batteryCapacityComparator = new BatteryCapacityComparator();
        ScreenDiagonalComparator screenDiagonalComparator = new ScreenDiagonalComparator();

        Arrays.sort(phones);

        System.out.println("Standard price comparator");
        for (Phone phone : phones) {
            System.out.println(phone.toString());
        }
        System.out.println();

        Arrays.sort(mobilePhones, screenDiagonalComparator);

        System.out.println("Screen diagonal comparator");
        for (Phone phone : mobilePhones) {
            System.out.println(phone.toString());
        }
        System.out.println();

        Arrays.sort(mobilePhones, batteryCapacityComparator);

        System.out.println("Battery capacity comparator");
        for (Phone phone : mobilePhones) {
            System.out.println(phone.toString());
        }
        System.out.println();

        for (Phone phone : phones) {
            phone.makeCall();
        }
        System.out.println();



    }
}
