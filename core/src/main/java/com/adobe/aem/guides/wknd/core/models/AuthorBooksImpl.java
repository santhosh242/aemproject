package com.adobe.aem.guides.wknd.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import com.adobe.aem.guides.wknd.core.models.AuthorBooks;
import com.adobe.aem.guides.wknd.core.models.MultifieldHelper;
import com.adobe.aem.guides.wknd.core.models.NastedHalper;

import java.util.*;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = AuthorBooks.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class AuthorBooksImpl implements AuthorBooks {
    private static final Logger LOG = LoggerFactory.getLogger(AuthorBooksImpl.class);

    @Inject
    Resource componentResource;

    @ValueMapValue
    @Default(values = "AEM")
    private String authorname;

    @ValueMapValue
    private List<String> books;


    @Override
    public String getAuthorName() {
        return authorname;
    }

    @Override
    public List<String> getAuthorBooks() {
        if(books!=null){
            return new ArrayList<String>(books);
        }else{
            return Collections.emptyList();
        }
    }


    @Override
    public List<MultifieldHelper> getBookDetailsWithNastedMultifield() {
        List<MultifieldHelper> bookDetailsNasted=new ArrayList<>();
        try {
            Resource bookDetailNasted=componentResource.getChild("bookdetailswithnastedmultifield");
            if(bookDetailNasted!=null){
                for (Resource bookNasted : bookDetailNasted.getChildren()) {
                    MultifieldHelper multifieldHelper=new MultifieldHelper(bookNasted);
                    if(bookNasted.hasChildren()){
                        List<NastedHalper> bookNastedList=new ArrayList<>();
                        Resource nastedResource=bookNasted.getChild("bookeditons");
                        for(Resource nasted : nastedResource.getChildren()){
                            bookNastedList.add(new NastedHalper(nasted));
                        }
                        multifieldHelper.setBookEditons(bookNastedList);
                    }
                    bookDetailsNasted.add(multifieldHelper);
                }
            }
        }catch (Exception e){
            LOG.info("\n ERROR while getting Book Details With Nasted Multifield {} ",e.getMessage());
        }
        LOG.info("\n SIZE Multifield {} ",bookDetailsNasted.size());
        return bookDetailsNasted;
    }

}
