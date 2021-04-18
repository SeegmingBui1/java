public class var {
    static public void main(String [] args) {
        byte s = 78, d = 89;
        boolean b = true;
        char c = 'a';
        // double f = 2899.68;
        // float f = (float)2899.68;
        float f = 2899.68F;

        d = (byte)f;
        f = (float)s;

        s = (byte)((float)d + f);

        c = 0x7684;
        c = '\t';

        s = -127;

        s += 10;

        // d++;

        System.out.println("double f = " + f);
        System.out.println("s = " + s + ", c = " + c);
        System.out.println("b = " + (byte)c);
        System.out.printf("s = %d, c = %c, d = %d\n", s, c, d);
    }
}

