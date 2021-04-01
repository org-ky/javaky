/*
* If a type implements two interfaces, and each interface define a method that has 
* identical signature, then in effect there is only one method, and they are not 
* distinguishable. 
* If, say, the two methods have conflicting return types, then it will be a compilation 
* error. 
* This is the general rule of inheritance, method overriding, hiding, and declarations, 
* and applies also to possible conflicts not only between 2 inherited interface methods, 
* but also an interface and a super class method, or even just conflicts due to type erasure 
* of generics.
*/
package interfaces;

public class InterfaceTest {
    interface Gift  { void present(); }
    interface Guest { void present(); }

    interface Presentable extends Gift, Guest { }

    public static void main(String[] args) {
        Presentable johnny = new Presentable() {
            @Override public void present() {
                System.out.println("Heeeereee's Johnny!!!");
            }
        };
        johnny.present();                     // "Heeeereee's Johnny!!!"

        ((Gift) johnny).present();            // "Heeeereee's Johnny!!!"
        ((Guest) johnny).present();           // "Heeeereee's Johnny!!!"

        Gift johnnyAsGift = (Gift) johnny;
        johnnyAsGift.present();               // "Heeeereee's Johnny!!!"

        Guest johnnyAsGuest = (Guest) johnny;
        johnnyAsGuest.present();              // "Heeeereee's Johnny!!!"

        DoubleInterface a = new DoubleInterface();

        a.f();
    }
}
