/**
 * @author Alberto Fernandez
 */
public class LifeForm
{
    private String domain;
    private String kingdom;
    private String phylum;
    private String class_;
    private String order;
    private String family;
    private String genus;
    private String species;
    private boolean initialized = false;

    public LifeForm(String d, String k, String p, String c, String o, String f, String g, String s)
    {
       domain = d;
       kingdom = k;
       phylum = p;
       class_ = c;
       order = o;
       family = f;
       genus = g;
       species = s;
       initialized = true;
    }

    private boolean isInitialized()
    {return initialized;}

    public void setSpecies(String species)
    {this.species = species;}

    public String getSpecies()
    {return species;}

    public void setDomain(String domain)
    {this.domain = domain;}

    public String getDomain()
    {return domain;}

    public void setKingdom(String kingdom)
    {this.kingdom = kingdom;}

    public String getKingdom()
    {return kingdom;}

    public void setPhylum(String phylum)
    {this.phylum = phylum;}

    public String getPhylum()
    {return phylum;}



}
