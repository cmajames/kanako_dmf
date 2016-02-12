/**
 * Base interface for USB Devices
 *
 * @author CJ <cmajames@sdf.org>
 * @since 2016-02-09
 */

package io.cmajames.kanako.engine.control;

public interface IUSBDevice {
    short getVendorId();
    short getProductId();
}
