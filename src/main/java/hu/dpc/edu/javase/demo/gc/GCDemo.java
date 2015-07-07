package hu.dpc.edu.javase.demo.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 *
 * @author IQJB
 */
public class GCDemo {
    public static void main(String[] args) throws InterruptedException {
        SoftReference<byte[]> sf = new SoftReference<>(new byte[1000000]);
        byte[] get = sf.get();
        
        WeakReference<byte[]>wref = new WeakReference<>(get);
        byte[] x = new byte[] {123,123,1,1};
        ReferenceQueue<byte[]>q= new ReferenceQueue<>();
        
        
        PhantomReference<byte[]>pref = new PhantomReference(x, q) {

            @Override
            public String toString() {
                return "My ByteArray";
            }
            
        };
        
        Reference<? extends byte[]> remove = q.remove();
                
               
    }
}
