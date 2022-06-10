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


    @Spy
    private TradeService tradeService = new TradeService();

    @InjectMocks
    private TradeService mockTradeService;

    @Mock
    private RegionalDao regionalDao;

    @Mock
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


        Mockito.when(regionalDaoManager.getRegionalDao(Region.TOKYO)).thenReturn(new TokyoDao());
        Mockito.when(regionalDao.getDataSource().getConnection()).thenReturn(Mockito.any());


        Mockito.when(regionalDao.getTradeDetails(123456789)).thenReturn(new TradeDetails(12345678,Region.TOKYO,1));
        Mockito.when(mockTradeService.getTradeDetails(123456789)).thenReturn(new TradeDetails());


        TradeDetails tradeDetails = mockTradeService.getTradeDetails(12345678);
        TradeDetails expectedTradeDetails = new TradeDetails();
        expectedTradeDetails.setTradeId(12345678);
        expectedTradeDetails.setStatus(0);
        expectedTradeDetails.setRegion(Region.TOKYO);

        assertEquals(expectedTradeDetails,tradeDetails);



    }

}
