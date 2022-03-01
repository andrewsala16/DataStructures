/**
 * Interface used to determine if publication is restorable (older than 20 years)
 * @author Andrew Sala
 * @version 1.0
 * Date of creation: Februray 19, 2021
 * Last Date Modified: Februrary 28, 2021
 */
public interface Restorable {
    // returns true if the object is restorable
    boolean isRestorable();
}
