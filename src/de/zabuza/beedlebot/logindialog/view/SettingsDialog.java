package de.zabuza.beedlebot.logindialog.view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import de.zabuza.beedlebot.exceptions.UnsupportedBrowserException;
import de.zabuza.beedlebot.logging.ILogger;
import de.zabuza.beedlebot.logging.LoggerFactory;
import de.zabuza.sparkle.webdriver.EBrowser;

/**
 * Dialog window for changing the settings of the tool.
 * 
 * @author Zabuza {@literal <zabuza.dev@gmail.com>}
 *
 */
public final class SettingsDialog extends JDialog {
	/**
	 * The title of the browser panel.
	 */
	private final static String BROWSER_TITLE = "Browser";
	/**
	 * The default amount of columns for fields of the view.
	 */
	private static final int DEFAULT_FIELD_COLUMNS = 10;
	/**
	 * The default font of the view.
	 */
	private static final String DEFAULT_FONT = "Tahoma";
	/**
	 * The default font size of the view.
	 */
	private static final int DEFAULT_FONT_SIZE = 11;
	/**
	 * The title of the dialog window.
	 */
	private final static String DIALOG_TITLE = "Settings";
	/**
	 * The title of the driver panel.
	 */
	private final static String DRIVER_TITLE = "Driver";
	/**
	 * The height of the dialog.
	 */
	private final static int FRAME_HEIGHT = 410;
	/**
	 * The width of the dialog.
	 */
	private final static int FRAME_WIDTH = 400;
	/**
	 * The origin offset of the dialog to the owner, in both directions.
	 */
	private final static int OWNER_OFFSET = 50;
	/**
	 * The title of the buttons for selection.
	 */
	private static final String SELECT_TITLE = "Search";
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Select binary button of the dialog for browsers.
	 */
	private JButton mBinaryBtn;
	/**
	 * The browser binary input field.
	 */
	private JTextField mBinaryField;
	/**
	 * The browser panel of the dialog.
	 */
	private JPanel mBrowserPanel;
	/**
	 * The button of the dialog for canceling.
	 */
	private JButton mCancelBtn;
	/**
	 * Select driver button of the dialog for Chrome.
	 */
	private JButton mChromeBtn;
	/**
	 * The driver input field for Chrome.
	 */
	private JTextField mChromeDriverField;
	/**
	 * Container of the dialog.
	 */
	private final Container mContainer;
	/**
	 * The driver panel of the dialog.
	 */
	private JPanel mDriverPanel;
	/**
	 * List of all elements of this dialog.
	 */
	private final List<JComponent> mElements;
	/**
	 * Select driver button of the dialog for Firefox.
	 */
	private JButton mFirefoxBtn;
	/**
	 * The driver input field for Firefox.
	 */
	private JTextField mFirefoxDriverField;
	/**
	 * Select driver button of the dialog for Internet Explorer.
	 */
	private JButton mInternetExplorerBtn;
	/**
	 * The driver input field for Internet Explorer.
	 */
	private JTextField mInternetExplorerDriverField;
	/**
	 * The logger to use for logging.
	 */
	private final ILogger mLogger;
	/**
	 * Select driver button of the dialog for Microsoft Edge.
	 */
	private JButton mMsEdgeBtn;
	/**
	 * The driver input field for Microsoft Edge.
	 */
	private JTextField mMsEdgeDriverField;
	/**
	 * Select driver button of the dialog for Opera.
	 */
	private JButton mOperaBtn;
	/**
	 * The driver input field for Opera.
	 */
	private JTextField mOperaDriverField;
	/**
	 * Select driver button of the dialog for Safari.
	 */
	private JButton mSafariBtn;
	/**
	 * The driver input field for Safari.
	 */
	private JTextField mSafariDriverField;
	/**
	 * The button of the dialog for saving.
	 */
	private JButton mSaveBtn;
	/**
	 * The trailer panel of the dialog.
	 */
	private JPanel mTrailerPanel;
	/**
	 * Select user profile button of the dialog for browsers.
	 */
	private JButton mUserProfileBtn;
	/**
	 * The browser user profile input field.
	 */
	private JTextField mUserProfileField;

	/**
	 * Creates a new settings dialog window.
	 * 
	 * @param owner
	 *            The owning frame of this dialog
	 */
	public SettingsDialog(final JFrame owner) {
		super(owner, DIALOG_TITLE);
		this.mContainer = getContentPane();
		this.mElements = new LinkedList<>();
		this.mLogger = LoggerFactory.getLogger();
		initialize(owner);
	}

	/**
	 * Adds an action listener to the given browser binary selection action.
	 * 
	 * @param listener
	 *            Listener to add
	 */
	public void addListenerToBinarySelectionAction(final ActionListener listener) {
		this.mBinaryBtn.addActionListener(listener);
	}

	/**
	 * Adds an action listener to the given browser driver selection action.
	 * 
	 * @param browser
	 *            Browser to add listener to its corresponding driver selection
	 *            action
	 * @param listener
	 *            Listener to add
	 * @throws UnsupportedBrowserException
	 *             If the given browser is not supported
	 */
	public void addListenerToBrowserDriverSelectionAction(final EBrowser browser, final ActionListener listener)
			throws UnsupportedBrowserException {
		if (browser == EBrowser.CHROME) {
			this.mChromeBtn.addActionListener(listener);
		} else if (browser == EBrowser.FIREFOX) {
			this.mFirefoxBtn.addActionListener(listener);
		} else if (browser == EBrowser.INTERNET_EXPLORER) {
			this.mInternetExplorerBtn.addActionListener(listener);
		} else if (browser == EBrowser.MS_EDGE) {
			this.mMsEdgeBtn.addActionListener(listener);
		} else if (browser == EBrowser.OPERA) {
			this.mOperaBtn.addActionListener(listener);
		} else if (browser == EBrowser.SAFARI) {
			this.mSafariBtn.addActionListener(listener);
		} else {
			throw new UnsupportedBrowserException(browser);
		}
	}

	/**
	 * Adds an action listener to the cancel action
	 * 
	 * @param listener
	 *            Listener to add
	 */
	public void addListenerToCancelAction(final ActionListener listener) {
		this.mCancelBtn.addActionListener(listener);
	}

	/**
	 * Adds an action listener to the save action
	 * 
	 * @param listener
	 *            Listener to add
	 */
	public void addListenerToSaveAction(final ActionListener listener) {
		this.mSaveBtn.addActionListener(listener);
	}

	/**
	 * Adds an action listener to the given browser user binary selection
	 * action.
	 * 
	 * @param listener
	 *            Listener to add
	 */
	public void addListenerToUserProfileSelectionAction(final ActionListener listener) {
		this.mUserProfileBtn.addActionListener(listener);
	}

	/**
	 * Gets the binary field.
	 * 
	 * @return The binary field
	 */
	public JTextField getBinaryField() {
		return this.mBinaryField;
	}

	/**
	 * Gets the driver field of the corresponding given browser.
	 * 
	 * @param browser
	 *            Browser to get its driver field
	 * @return The driver field corresponding to the given browser
	 * @throws UnsupportedBrowserException
	 *             If the given browser is not supported
	 */
	public JTextField getBrowserDriverField(final EBrowser browser) throws UnsupportedBrowserException {
		if (browser == EBrowser.CHROME) {
			return this.mChromeDriverField;
		} else if (browser == EBrowser.FIREFOX) {
			return this.mFirefoxDriverField;
		} else if (browser == EBrowser.INTERNET_EXPLORER) {
			return this.mInternetExplorerDriverField;
		} else if (browser == EBrowser.MS_EDGE) {
			return this.mMsEdgeDriverField;
		} else if (browser == EBrowser.OPERA) {
			return this.mOperaDriverField;
		} else if (browser == EBrowser.SAFARI) {
			return this.mSafariDriverField;
		} else {
			throw new UnsupportedBrowserException(browser);
		}
	}

	/**
	 * Gets the user profile field.
	 * 
	 * @return The user profile field
	 */
	public JTextField getUserProfileField() {
		return this.mUserProfileField;
	}

	/**
	 * Enables or disables all elements of the dialog.
	 * 
	 * @param enabled
	 *            Whether the elements should be enabled or disabled
	 */
	public void setAllElementsEnabled(final boolean enabled) {
		for (final JComponent element : this.mElements) {
			element.setEnabled(enabled);
		}
	}

	/**
	 * Initialize the contents of the view.
	 * 
	 * @param owner
	 *            The owning frame of this dialog
	 */
	private void initialize(final JFrame owner) {
		if (this.mLogger.isDebugEnabled()) {
			this.mLogger.logDebug("Initializing SettingsDialog");
		}

		setIconImage(owner.getIconImage());
		setBounds(owner.getX() + OWNER_OFFSET, owner.getY() + OWNER_OFFSET, FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		initializePanels();
		initializeLabels();
		initializeButtons();
		initializeInputFields();
	}

	/**
	 * Initialize the buttons.
	 */
	private void initializeButtons() {
		this.mChromeBtn = new JButton(SELECT_TITLE);
		this.mChromeBtn.setBounds(290, 30, 80, 20);
		this.mDriverPanel.add(this.mChromeBtn);
		this.mElements.add(this.mChromeBtn);

		this.mFirefoxBtn = new JButton(SELECT_TITLE);
		this.mFirefoxBtn.setBounds(290, 60, 80, 20);
		this.mDriverPanel.add(this.mFirefoxBtn);
		this.mElements.add(this.mFirefoxBtn);

		this.mInternetExplorerBtn = new JButton(SELECT_TITLE);
		this.mInternetExplorerBtn.setBounds(290, 90, 80, 20);
		this.mDriverPanel.add(this.mInternetExplorerBtn);
		this.mElements.add(this.mInternetExplorerBtn);

		this.mMsEdgeBtn = new JButton(SELECT_TITLE);
		this.mMsEdgeBtn.setBounds(290, 120, 80, 20);
		this.mDriverPanel.add(this.mMsEdgeBtn);
		this.mElements.add(this.mMsEdgeBtn);

		this.mOperaBtn = new JButton(SELECT_TITLE);
		this.mOperaBtn.setBounds(290, 150, 80, 20);
		this.mDriverPanel.add(this.mOperaBtn);
		this.mElements.add(this.mOperaBtn);

		this.mSafariBtn = new JButton(SELECT_TITLE);
		this.mSafariBtn.setBounds(290, 180, 80, 20);
		this.mDriverPanel.add(this.mSafariBtn);
		this.mElements.add(this.mSafariBtn);

		this.mBinaryBtn = new JButton(SELECT_TITLE);
		this.mBinaryBtn.setBounds(290, 30, 80, 20);
		this.mBrowserPanel.add(this.mBinaryBtn);
		this.mElements.add(this.mBinaryBtn);

		this.mUserProfileBtn = new JButton(SELECT_TITLE);
		this.mUserProfileBtn.setBounds(290, 60, 80, 20);
		this.mBrowserPanel.add(this.mUserProfileBtn);
		this.mElements.add(this.mUserProfileBtn);

		this.mSaveBtn = new JButton("Save");
		this.mSaveBtn.setBounds((FRAME_WIDTH / 2) - 100, 345, 80, 20);
		this.mTrailerPanel.add(this.mSaveBtn);
		this.mElements.add(this.mSaveBtn);

		this.mCancelBtn = new JButton("Cancel");
		this.mCancelBtn.setBounds((FRAME_WIDTH / 2) + 20, 345, 80, 20);
		this.mTrailerPanel.add(this.mCancelBtn);
		this.mElements.add(this.mCancelBtn);
	}

	/**
	 * Initialize the text fields.
	 */
	private void initializeInputFields() {
		this.mChromeDriverField = new JTextField();
		this.mChromeDriverField.setHorizontalAlignment(SwingConstants.LEFT);
		this.mChromeDriverField.setBounds(80, 30, 200, 20);
		this.mDriverPanel.add(this.mChromeDriverField);
		this.mElements.add(this.mChromeDriverField);
		this.mChromeDriverField.setColumns(DEFAULT_FIELD_COLUMNS);

		this.mFirefoxDriverField = new JTextField();
		this.mFirefoxDriverField.setHorizontalAlignment(SwingConstants.LEFT);
		this.mFirefoxDriverField.setBounds(80, 60, 200, 20);
		this.mDriverPanel.add(this.mFirefoxDriverField);
		this.mElements.add(this.mFirefoxDriverField);
		this.mFirefoxDriverField.setColumns(DEFAULT_FIELD_COLUMNS);

		this.mInternetExplorerDriverField = new JTextField();
		this.mInternetExplorerDriverField.setHorizontalAlignment(SwingConstants.LEFT);
		this.mInternetExplorerDriverField.setBounds(80, 90, 200, 20);
		this.mDriverPanel.add(this.mInternetExplorerDriverField);
		this.mElements.add(this.mInternetExplorerDriverField);
		this.mInternetExplorerDriverField.setColumns(DEFAULT_FIELD_COLUMNS);

		this.mMsEdgeDriverField = new JTextField();
		this.mMsEdgeDriverField.setHorizontalAlignment(SwingConstants.LEFT);
		this.mMsEdgeDriverField.setBounds(80, 120, 200, 20);
		this.mDriverPanel.add(this.mMsEdgeDriverField);
		this.mElements.add(this.mMsEdgeDriverField);
		this.mMsEdgeDriverField.setColumns(DEFAULT_FIELD_COLUMNS);

		this.mOperaDriverField = new JTextField();
		this.mOperaDriverField.setHorizontalAlignment(SwingConstants.LEFT);
		this.mOperaDriverField.setBounds(80, 150, 200, 20);
		this.mDriverPanel.add(this.mOperaDriverField);
		this.mElements.add(this.mOperaDriverField);
		this.mOperaDriverField.setColumns(DEFAULT_FIELD_COLUMNS);

		this.mSafariDriverField = new JTextField();
		this.mSafariDriverField.setHorizontalAlignment(SwingConstants.LEFT);
		this.mSafariDriverField.setBounds(80, 180, 200, 20);
		this.mDriverPanel.add(this.mSafariDriverField);
		this.mElements.add(this.mSafariDriverField);
		this.mSafariDriverField.setColumns(DEFAULT_FIELD_COLUMNS);

		this.mBinaryField = new JTextField();
		this.mBinaryField.setHorizontalAlignment(SwingConstants.LEFT);
		this.mBinaryField.setBounds(80, 30, 200, 20);
		this.mBrowserPanel.add(this.mBinaryField);
		this.mElements.add(this.mBinaryField);
		this.mBinaryField.setColumns(DEFAULT_FIELD_COLUMNS);

		this.mUserProfileField = new JTextField();
		this.mUserProfileField.setHorizontalAlignment(SwingConstants.LEFT);
		this.mUserProfileField.setBounds(80, 60, 200, 20);
		this.mBrowserPanel.add(this.mUserProfileField);
		this.mElements.add(this.mUserProfileField);
		this.mUserProfileField.setColumns(DEFAULT_FIELD_COLUMNS);
	}

	/**
	 * Initialize the labels.
	 */
	private void initializeLabels() {
		final JLabel mChromeDriverLbl = new JLabel("Chrome:");
		mChromeDriverLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		mChromeDriverLbl.setFont(new Font(DEFAULT_FONT, Font.BOLD, DEFAULT_FONT_SIZE + 1));
		mChromeDriverLbl.setBounds(10, 30, 60, 14);
		this.mDriverPanel.add(mChromeDriverLbl);

		final JLabel mFirefoxDriverLbl = new JLabel("Firefox:");
		mFirefoxDriverLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		mFirefoxDriverLbl.setFont(new Font(DEFAULT_FONT, Font.BOLD, DEFAULT_FONT_SIZE + 1));
		mFirefoxDriverLbl.setBounds(10, 60, 60, 14);
		this.mDriverPanel.add(mFirefoxDriverLbl);

		final JLabel mInternetExplorerDriverLbl = new JLabel("IE:");
		mInternetExplorerDriverLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		mInternetExplorerDriverLbl.setFont(new Font(DEFAULT_FONT, Font.BOLD, DEFAULT_FONT_SIZE + 1));
		mInternetExplorerDriverLbl.setBounds(10, 90, 60, 14);
		this.mDriverPanel.add(mInternetExplorerDriverLbl);

		final JLabel mMsEdgeDriverLbl = new JLabel("MS Edge:");
		mMsEdgeDriverLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		mMsEdgeDriverLbl.setFont(new Font(DEFAULT_FONT, Font.BOLD, DEFAULT_FONT_SIZE + 1));
		mMsEdgeDriverLbl.setBounds(10, 120, 60, 14);
		this.mDriverPanel.add(mMsEdgeDriverLbl);

		final JLabel mOperaDriverLbl = new JLabel("Opera:");
		mOperaDriverLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		mOperaDriverLbl.setFont(new Font(DEFAULT_FONT, Font.BOLD, DEFAULT_FONT_SIZE + 1));
		mOperaDriverLbl.setBounds(10, 150, 60, 14);
		this.mDriverPanel.add(mOperaDriverLbl);

		final JLabel mSafariDriverLbl = new JLabel("Safari:");
		mSafariDriverLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		mSafariDriverLbl.setFont(new Font(DEFAULT_FONT, Font.BOLD, DEFAULT_FONT_SIZE + 1));
		mSafariDriverLbl.setBounds(10, 180, 60, 14);
		this.mDriverPanel.add(mSafariDriverLbl);

		final JLabel mBinaryLbl = new JLabel("Binary:");
		mBinaryLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		mBinaryLbl.setFont(new Font(DEFAULT_FONT, Font.BOLD, DEFAULT_FONT_SIZE + 1));
		mBinaryLbl.setBounds(10, 30, 60, 14);
		this.mBrowserPanel.add(mBinaryLbl);

		final JLabel mUserProfileLbl = new JLabel("Profile:");
		mUserProfileLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		mUserProfileLbl.setFont(new Font(DEFAULT_FONT, Font.BOLD, DEFAULT_FONT_SIZE + 1));
		mUserProfileLbl.setBounds(10, 60, 60, 14);
		this.mBrowserPanel.add(mUserProfileLbl);
	}

	/**
	 * Initialize the panels.
	 */
	private void initializePanels() {
		this.mDriverPanel = new JPanel();
		this.mDriverPanel.setBounds(10, 10, FRAME_WIDTH - 25, 220);
		final TitledBorder titledBorderDriver = BorderFactory.createTitledBorder(DRIVER_TITLE);
		this.mDriverPanel.setBorder(titledBorderDriver);
		this.mContainer.add(this.mDriverPanel);
		this.mDriverPanel.setLayout(null);

		this.mBrowserPanel = new JPanel();
		this.mBrowserPanel.setBounds(10, 230, FRAME_WIDTH - 25, 100);
		final TitledBorder titledBorderBrowser = BorderFactory.createTitledBorder(BROWSER_TITLE);
		this.mBrowserPanel.setBorder(titledBorderBrowser);
		this.mContainer.add(this.mBrowserPanel);
		this.mBrowserPanel.setLayout(null);

		this.mTrailerPanel = new JPanel();
		this.mTrailerPanel.setBounds(10, 340, FRAME_WIDTH - 25, 70);
		this.mContainer.add(this.mTrailerPanel);
		this.mTrailerPanel.setLayout(null);
	}
}
