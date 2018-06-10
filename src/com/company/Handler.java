package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {

    private String name;
    private boolean isNewUser = false;
    private boolean isSkill = false;
    private boolean isSearchUser = false;
    private String[] skills = {"CodeIgniter", "CSS3", "Sinatra"};

    @Override
    public void startElement(String namespace, String localName, String qName, Attributes attr) {
        if(qName.equals("name")){
            isNewUser = true;
        } else if(qName.equals("skill")){
            isSkill = true;
        }
    }

    @Override
    public void endElement(String namespace, String localName, String qName) throws SAXException {
        if(qName.equals("user") && isSearchUser){
            System.out.println(name);
            isSearchUser = false;
        }
    }

    @Override
    public void characters(char []ch, int start, int end) {
        if(isNewUser) {
            name = new String(ch, start, end);
            isNewUser = false;
        } else if (isSkill) {
            String skill = new String(ch, start, end);
            for(int i = 0; i < 3; i++){
                if (skills[i].equals(skill)) {
                    isSearchUser = true;
                }
            }
            isSkill = false;
        }
    }


}
