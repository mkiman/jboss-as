/**
 * 
 */
package org.jboss.as.model.socket;

import java.net.NetworkInterface;
import java.util.Collection;

import javax.xml.stream.XMLStreamException;

import org.jboss.as.model.AbstractModelUpdate;
import org.jboss.as.model.Element;
import org.jboss.staxmapper.XMLExtendedStreamReader;

/**
 * Indicates that a network interface must be a {@link NetworkInterface#isLoopback() loopback interface} 
 * to match the criteria.
 * 
 * @author Brian Stansberry
 */
public class SimpleCriteriaElement extends AbstractInterfaceCriteriaElement<SimpleCriteriaElement> {

    private static final long serialVersionUID = -649277969243521207L;

    
    /**
     * Creates a new LoopbackCriteriaElement by parsing an xml stream
     * 
     * @param reader stream reader used to read the xml
     * @param type the specific type of this element
     * 
     * @throws XMLStreamException if an error occurs
     */
    public SimpleCriteriaElement(XMLExtendedStreamReader reader, Element type, InterfaceCriteria criteria) throws XMLStreamException {
        super(reader, type, criteria);
        if (criteria == null) {
            throw new IllegalArgumentException("criteria is null");
        }
    }
    
    /** 
     * {@inheritDoc}
     * 
     * This implementation checks that there are no attributes and no child elements.
     */
    protected void processXmlStream(XMLExtendedStreamReader reader) throws XMLStreamException {
        requireNoAttributes(reader);
        requireNoContent(reader);
    }

    @Override
    protected Class<SimpleCriteriaElement> getElementClass() {
        return SimpleCriteriaElement.class;
    }

    @Override
    protected void appendDifference(Collection<AbstractModelUpdate<SimpleCriteriaElement>> target,
            SimpleCriteriaElement other) {
        // no mutable state        
    }
    
    

}