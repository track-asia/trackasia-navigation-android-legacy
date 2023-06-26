package com.mapbox.services.android.navigation.ui.v5;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;

public class FeedbackButton extends ConstraintLayout implements NavigationButton {
  private FloatingActionButton feedbackFab;
  private MultiOnClickListener multiOnClickListener;

  public FeedbackButton(Context context) {
    this(context, null);
  }

  public FeedbackButton(Context context, AttributeSet attrs) {
    this(context, attrs, -1);
  }

  public FeedbackButton(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    initialize(context);
  }

  /**
   * Adds an onClickListener to the button
   *
   * @param onClickListener to add
   */
  @Override
  public void addOnClickListener(OnClickListener onClickListener) {
    multiOnClickListener.addListener(onClickListener);
  }

  /**
   * Removes an onClickListener from the button
   *
   * @param onClickListener to remove
   */
  @Override
  public void removeOnClickListener(OnClickListener onClickListener) {
    multiOnClickListener.removeListener(onClickListener);
  }

  /**
   * Hides the button
   */
  @Override
  public void hide() {
    setVisibility(GONE);
  }

  /**
   * Shows the button
   */
  @Override
  public void show() {
    setVisibility(VISIBLE);
  }

  @Override
  protected void onFinishInflate() {
    super.onFinishInflate();
    bind();
  }

  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    setupOnClickListeners();
  }

  @Override
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    clearListeners();
  }


  private void setupOnClickListeners() {
    multiOnClickListener = new MultiOnClickListener();
    feedbackFab.setOnClickListener(multiOnClickListener);
  }

  private void clearListeners() {
    multiOnClickListener.clearListeners();
    multiOnClickListener = null;
    setOnClickListener(null);
  }

  private void initialize(Context context) {
    inflate(context, R.layout.feedback_button_layout, this);
  }

  private void bind() {
    feedbackFab = findViewById(R.id.feedbackFab);
  }
}
