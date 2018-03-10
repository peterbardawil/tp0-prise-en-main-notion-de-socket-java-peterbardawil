/**
 *
 * @package  app1
 * @version  1.0
 * @developer  Peter Bardawil
 *
 */
package app1;

public class main {

    private final String id;

    private final String data;

    private String commentaires;
    
    /**
     * @param db 
     */
    public Data(DataBuilder db) {
        this.id=db.id;
        this.data=db.data;
        this.commentaires=db.commentaires;
    }

    /**
     * @return the _id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @return data
     */
    public String getData() {
        return this.data;
    }

    /**
     * @return commentaires
     */
    public String getCommentaires() {
        return commentaires;
    }

    /**
     * @param string comment
     */
    public void setCommentaires(String comment) {
        this.commentaires = comment;
    }

    /**
     * Une classe builder interne (et static)
     */
    public static class DataBuilder {

        String id;

        String data;

        String commentaires;
        
        /** 
         * @param id
         * @param data 
         */
        public DataBuilder(String id,String data) {
            this.id=id;
            this.data=data;
        }
        /**
         * @param String commentaire
         * @return un DataBuilder pour enchaîner les mise a jour du builder
         */
        public DataBuilder commentaire(String comment) {
            this.commentaires=comment;
            return this;
        }
        
        /**
         * @return objet à créer
         */
        public Data build(){
            return new Data(this);
        }
    }
}