package hu.dpc.edu.javase.demo;

/**
 *
 * @author IQJB
 */
public abstract class InfoExposerBaseClass implements InfoProducer {

    public abstract void appendInfo(StringBuilder sb);
    
    @Override
    public final String getInfo() {
        StringBuilder sb = new StringBuilder();
        appendInfo(sb);
        return sb.toString();
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append('{');
        appendInfo(sb);
        sb.append('}');
        return sb.toString();
    }
}
