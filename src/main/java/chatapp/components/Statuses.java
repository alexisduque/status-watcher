/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.components;

import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alexis
 */

@Singleton

public class Statuses {
    
    public Map<String, String> statusMap = new HashMap();
    
}
