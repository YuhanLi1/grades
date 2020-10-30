import java.util.*;

class RankingGrade implements Comparator<grade>
{
    public int compare(grade g1, grade g2)
    {
        int GradeResult =  (int)(g1.getGrade().compareTo(g2.getGrade()));
        if(GradeResult != 0)
        {
            return GradeResult;
        }
        else
        {
            int SiteResult =  g1.getSite() - g2.getSite();
            if(SiteResult != 0)
            {
                return SiteResult;
            }
            else
            {
                return (int) (g1.getlastN().compareTo(g2.getlastN()));
            } 

        }
    }
}