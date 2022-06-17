package trade;

import static org.junit.jupiter.api.Assertions.*;

import ds.MySqlDataSource;
import ds.SqlServerDataSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.sql.DataSource;
import java.sql.SQLException;


@ExtendWith(MockitoExtension.class)
public class TradeServiceTest {


//    @Spy
//    private TradeService tradeService = new TradeService();

    @InjectMocks
    private TradeService tradeService;

    @Mock
    private RegionalDao regionalDao;

    @Spy
    private RegionalDaoManager regionalDaoManager;


    @Mock
    private TradeDetails tradeDetails;






    @Test
    public void getTradeRegionShouldBeTrue() {


    Region region = tradeService.getTradeRegion(121456903);
    Region expectedRegion = Region.LONDON;
        assertEquals(expectedRegion,region);

        region = tradeService.getTradeRegion(123456903);
        expectedRegion = Region.TOKYO;

        assertEquals(expectedRegion,region);

        region = tradeService.getTradeRegion(12236547);
        expectedRegion = Region.NEWYORK;

        assertEquals(expectedRegion,region);


    }

    @Test
    public void getTradeRegionShouldThrowException() {

        Executable e =() -> tradeService.getTradeRegion(129456903);
        assertThrows(IllegalArgumentException.class,e);

    }


    @Test
    public void getTradeDetailsShouldBeTrue() throws SQLException {

        TokyoDao mockTokyoDao = Mockito.mock(TokyoDao.class);
        Mockito.when(mockTokyoDao.getTradeDetails(Mockito.any(long.class))).thenReturn(new TradeDetails(12345678,Region.TOKYO,0));
//        Mockito.when(regionalDaoManager.getRegionalDao(Region.TOKYO)).thenReturn(new Mockito().an);
//        Mockito.when(regionalDao.getDataSource().getConnection()).thenReturn(Mockito.any());


//        Mockito.when(regionalDao.getTradeDetails(123456789)).thenReturn(new TradeDetails(12345678,Region.TOKYO,1));
//        Mockito.when(mockTradeService.getTradeDetails(123456789)).thenReturn(new TradeDetails());


        TradeDetails tradeDetails = tradeService.getTradeDetails(12345678);
        TradeDetails expectedTradeDetails = new TradeDetails();
        expectedTradeDetails.setTradeId(12345678);
        expectedTradeDetails.setStatus(0);
        expectedTradeDetails.setRegion(Region.TOKYO);

        assertEquals(expectedTradeDetails,tradeDetails);



    }


    @Test
    public void getTradeDetailsShouldThrowException() {
        Mockito.when(regionalDao.getTradeDetails(Mockito.anyLong())).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> regionalDao.getTradeDetails(12890123));
    }


    @Test
    public void getTradeDetailsShouldBeNotNull(){
        Mockito.when(regionalDao.getTradeDetails(Mockito.any(long.class))).thenReturn(new TradeDetails());
        TradeDetails tradeDetails = regionalDao.getTradeDetails(12134567);
        assertNotNull(tradeDetails);

    }


}
