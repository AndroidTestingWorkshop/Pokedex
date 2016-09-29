package gojek.pokedex;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import gojek.pokedex.main.MainPresenter;
import gojek.pokedex.main.MainView;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    private MainPresenter presenter;

    @Mock
    MainView view;

    @Before
    public void setUp() throws Exception {
        presenter = new MainPresenter(view);
    }
}