import java.util.*;

public class Utf32to8 {

    public static void main(String[] args) {

        int utf32sample1 = 0b0000_0000_0000_0000_0000_0000_0011_0101;



    }

    public static byte[] utf32ToUtf8(int utf32) {

        if ((0xFFFF_FF80 & utf32) == 0) {
            // 7 bits only, then it is ASCII -> one UTF 8 block
            return new byte[] {(byte) utf32};
        } else if ((0xFFFF_F800 & utf32) == 0) {
            // 11 bits only, -> two UTF 8 blocks
            byte b1 = (byte) (utf32 & 0x3F);
            utf32 >>= 6;
            return new byte[] {(byte) (0xC0 | utf32), (byte) (0x80 | b1)};
        } else if ((0xFFFF_0000 & utf32) == 0) {
            // 16 bits only, -> three UTF 8 blocks
            byte b2 = (byte) (utf32 & 0x3F);
            utf32 >>= 6;
            byte b1 = (byte) (utf32 & 0x3F);
            utf32 >>= 6;
            return new byte[] {(byte) (0xE0 | utf32), (byte) (0x80 | b1), (byte) (0x80 | b2)};
        } else if ((0xFFE0_0000 & utf32) == 0) {
            // 21 bits or more, -> four UTF 8 blocks

        }





        byte[] bla = new byte[1];
        return bla;
    }

}
